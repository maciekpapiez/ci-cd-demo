#!/bin/bash

mkdir -p /srv/app
mkdir -p /srv/backup

if [ -f /srv/app/test-app.jar ]; then
	mv "/srv/app/test-app.jar" "/srv/backup/test-app-$(date --universal).jar"
fi