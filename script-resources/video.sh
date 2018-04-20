#!/bin/sh

# Read the command line parameters
request_id=$1
sound_track=$2

# Stitch all the tweets image and generate the video
ffmpeg -y -r 1/5 -i "${request_id}/screen_%d.jpeg" -c:v libx264 -vf "fps=25,format=yuv420p,scale=720:-1" "${request_id}/tweets".mp4

# Generate the profile video
ffmpeg -y -r 1/5 -i "${request_id}/profile.gif" -c:v libx264 -pix_fmt yuv420p -vf scale=720:-1 "${request_id}/profile".mp4

# Create the file
#profile_filepath=`find $PWD -name "${request_id}/profile".mp4`
#tweets_filepath=`find $PWD -name "${request_id}/tweets".mp4`
profile_filepath=`find $PWD"/${request_id}" -name "profile".mp4`
tweets_filepath=`find $PWD"/${request_id}" -name "tweets".mp4`
<<<<<<< HEAD:script-resources/video.sh
echo -e “file ${profile_filepath}\nfile ${tweets_filepath}" > "${request_id}/temp.txt"
=======
echo -e "file ${profile_filepath}\nfile ${tweets_filepath}" > "${request_id}/temp.txt"
>>>>>>> 49b56314bae5ad260c0c2682b3ae41e4d1e80935:shell_scripts/video.sh

# Merge the videos
ffmpeg -y -f concat -safe 0 -i "${request_id}/temp.txt" -codec copy "${request_id}/final.mp4"

# Make the final video
video_length=`ffprobe -v error -show_entries format=duration -of default=noprint_wrappers=1:nokey=1 "${request_id}/final.mp4"`

# Add the audio track
ffmpeg -y -i "${request_id}/final.mp4" -i $sound_track -codec copy -r 1 -t $video_length "${request_id}/final.mov"
