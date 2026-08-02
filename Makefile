.PHONY: start stop dev build package test test-e2e clean

# Carrega as variáveis do .env automaticamente
include .env
export

start:
	./mvnw clean package payara-micro:start

stop:
	./mvnw payara-micro:stop

dev:
	./mvnw package payara-micro:dev

build:
	./mvnw package

package:
	./mvnw clean package

test:
	./mvnw test

# Requires MySQL + app already running (e.g. make start).
# Uses system Chrome/Chromium, or Chrome for Testing under .tools/ (make chrome-tools).
test-e2e: chrome-tools
	@export CHROME_BIN="$${CHROME_BIN:-$(CURDIR)/.tools/chrome-linux64/chrome}"; \
	export LD_LIBRARY_PATH="$(CURDIR)/.tools/chrome-libs/usr/lib/x86_64-linux-gnu:$(CURDIR)/.tools/chrome-linux64:$${LD_LIBRARY_PATH}"; \
	./mvnw verify -Pe2e

# Download Chrome for Testing + minimal shared libs (no sudo) into .tools/
chrome-tools:
	@bash scripts/setup-chrome-tools.sh

clean:
	./mvnw clean
