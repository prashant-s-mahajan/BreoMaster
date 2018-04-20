#!/bin/bash

# Read the command line arguments
request_id=$1
profile_picture_url=$2
name=$3
twitter_handle=$4
bio=$5
location=$6
website=$7
joined_date=$8
tweets=$9
following=${10}
followers=${11}
likes=${12}
tweets_content=${13}
background_picture_url=${14}
audio_track=${15}

# create the directory for the request
mkdir $request_id
# download the pictures
wget $profile_picture_url -O "${request_id}/${request_id}_profile.jpeg"
wget $background_picture_url -O "${request_id}/${request_id}_background.jpeg"
echo -e $tweets_content > "${request_id}/tweets.txt"

target/script-resources/profile.sh "${request_id}" "${request_id}/${request_id}_profile.jpeg" "${name}" "${twitter_handle}" "${bio}" "${location}" "${website}" "${joined_date}" "${tweets}" "${following}" "${followers}" "${likes}"
