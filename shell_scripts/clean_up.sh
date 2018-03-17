#!/bin/bash

# Read the command line argument
request_id=$1

# Delete the files
rm -rf "${request_id}/background_dark.jpeg"
rm -rf "${request_id}/"*.jpg
rm -rf "${request_id}/"*.jpeg
rm -rf "${request_id}/"*.gif
rm -rf "${request_id}/"*.txt
rm -rf "${request_id}/"*.mp4
