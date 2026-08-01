.PHONY: start stop dev build package test clean

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

clean:
	./mvnw clean
