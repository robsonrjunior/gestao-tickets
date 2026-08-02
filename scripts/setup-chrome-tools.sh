#!/usr/bin/env bash
set -euo pipefail

ROOT="$(cd "$(dirname "$0")/.." && pwd)"
TOOLS="$ROOT/.tools"
CHROME_DIR="$TOOLS/chrome-linux64"
LIBS="$TOOLS/chrome-libs"
CHROME_VERSION="${CHROME_FOR_TESTING_VERSION:-151.0.7922.71}"

if [[ -x "$CHROME_DIR/chrome" ]]; then
  if "$CHROME_DIR/chrome" --version >/dev/null 2>&1 \
    || LD_LIBRARY_PATH="$LIBS/usr/lib/x86_64-linux-gnu:$CHROME_DIR:${LD_LIBRARY_PATH:-}" \
       "$CHROME_DIR/chrome" --version >/dev/null 2>&1; then
    echo "Chrome for Testing already available at $CHROME_DIR/chrome"
    exit 0
  fi
fi

mkdir -p "$TOOLS"
TMP="$(mktemp -d)"
trap 'rm -rf "$TMP"' EXIT

echo "Downloading Chrome for Testing ${CHROME_VERSION}..."
curl -fsSL -o "$TMP/chrome.zip" \
  "https://storage.googleapis.com/chrome-for-testing-public/${CHROME_VERSION}/linux64/chrome-linux64.zip"
python3 - "$TMP/chrome.zip" "$TOOLS" <<'PY'
import sys, zipfile
zipfile.ZipFile(sys.argv[1]).extractall(sys.argv[2])
PY
chmod +x "$CHROME_DIR/chrome" "$CHROME_DIR/chrome_crashpad_handler" 2>/dev/null || true
find "$CHROME_DIR" -maxdepth 1 -type f -exec chmod +x {} \; 2>/dev/null || true
# Ensure crashpad is executable even if archive was already extracted earlier
if [[ -f "$CHROME_DIR/chrome_crashpad_handler" ]]; then
  chmod +x "$CHROME_DIR/chrome_crashpad_handler"
fi

echo "Downloading minimal shared libraries (apt-get download, no install)..."
mkdir -p "$LIBS" "$TMP/debs"
(
  cd "$TMP/debs"
  apt-get download \
    libnspr4 libnss3 \
    libasound2t64 libatk-bridge2.0-0t64 libatk1.0-0t64 libatspi2.0-0t64 \
    libcups2t64 libgbm1 libpango-1.0-0 libcairo2 \
    libxcomposite1 libxdamage1 libxfixes3 libxrandr2 libxkbcommon0 \
    libxcb1 libx11-6 libxext6 >/dev/null 2>&1 || true
  for deb in *.deb; do
    [[ -f "$deb" ]] || continue
    dpkg-deb -x "$deb" "$LIBS"
  done
)

export LD_LIBRARY_PATH="$LIBS/usr/lib/x86_64-linux-gnu:$CHROME_DIR:${LD_LIBRARY_PATH:-}"
if ! "$CHROME_DIR/chrome" --version; then
  echo "Chrome binary present but failed to start. Install system Chrome/Chromium or missing libs." >&2
  exit 1
fi

echo "Chrome tools ready: $CHROME_DIR/chrome"
