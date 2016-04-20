#!/bin/bash

aws s3 cp s3://xsolve-ci-cd-demo/application.yml /srv/app --region eu-central-1

if [ ! -f /etc/init.d/test-app ]; then
	sudo ln -s /srv/app/test-app.jar /etc/init.d/test-app
fi