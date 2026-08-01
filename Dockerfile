FROM payara/server-web:7.2026.5
COPY target/gestao-tickets.war $DEPLOY_DIR
