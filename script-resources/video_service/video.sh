#!/bin/bash

request_id=$1
background_track=$2

# merge and create a video
ffmpeg -y -r 1/5 -i "temp/${request_id}/%d.jpeg" -c:v libx264 -vf "fps=25,format=yuv420p,scale=720:-1" "temp/${request_id}/${request_id}".mp4

# Make the final video
video_length=`ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 "temp/${request_id}/${request_id}.mp4"`

# Add the audio track
ffmpeg -y -i "temp/${request_id}/${request_id}.mp4" -i $background_track -codec copy -r 1 -t $video_length "temp/${request_id}/${request_id}.mov"
