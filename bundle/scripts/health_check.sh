#!/bin/bash

while(true); do
	curl http://localhost:8080/health && break;
	sleep 1;
done