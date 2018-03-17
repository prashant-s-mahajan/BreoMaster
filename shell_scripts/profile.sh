#!/bin/bash

# Read the command line arguments
request_id=$1
picture=$2
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

echo "tweets:${tweets}"

# Load the config file
source target/script-resources/config.sh

# create a blank black image 
convert -size "${profile_bwidth}"x"${profile_bheight}" xc:black "${request_id}/profile".gif

# Resize the profile picture to size 300x300
convert $picture -resize 300x300 "${request_id}/profile_300_300".gif
# Place the profile picture on the image
composite -geometry +20+20 "${request_id}/profile_300_300".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image for name 
convert -background none -size "${name_bwidth}"x"${name_bheight}" -font Verdana -fill white -pointsize 30 -gravity West Caption:"${name}" "${request_id}/name".gif
# Place the name on the image
composite -geometry  +350-5 "${request_id}/name".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image with twitter handle
convert -background none -size "${handle_bwidth}"x"${handle_bheight}" -font Verdana -fill white -pointsize 22 -gravity West label:"${twitter_handle}" "${request_id}/handle".gif
# Place the twitter handle on the image
composite -geometry  +350+35 "${request_id}/handle".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image with bio
convert -background none -size "${bio_bwidth}"x"${bio_bheight}" -font Verdana -fill white -pointsize 16  -gravity West caption:"${bio}" "${request_id}/bio".gif
# Place the bio on the image
composite -geometry  +350+105 "${request_id}/bio".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image with location
convert -background none -size "${location_bwidth}"x"${location_bheight}" -font Verdana -fill white -pointsize 16 -gravity West label:"${location}" "${request_id}/location".gif
# Place the location on the image
composite -geometry  +350+200  "${request_id}/location".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image for website
convert -background none -size "${website_bwidth}"x"${website_bheight}" -font Verdana -fill white -pointsize 16 -gravity West label:"${website}" "${request_id}/website".gif
# Place the website on the image
composite -geometry  +350+230  "${request_id}/website".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image for date joined
convert -background none -size "${joined_date_bwidth}"x"${joined_date_bheight}" -font Verdana -fill white -pointsize 16 -gravity West label:"${joined_date}" "${request_id}/joined_date".gif
# Place the date on the image
composite -geometry  +350+260  "${request_id}/joined_date".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image for title "Tweets"
convert -background none -size 300x80 -font Verdana -fill white -pointsize 22 -gravity West label:"Tweets" "${request_id}/tweets_header".gif
# Place the title on the image
composite -geometry  +670+40  "${request_id}/tweets_header".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image for number of tweets
convert -background none -size "${tweet_bwidth}"x"${tweet_bheight}" -font Verdana -fill white -pointsize 28 -gravity West label:"${tweets}" "${request_id}/tweets_count".gif
# Place the number of tweets on the image
composite -geometry  +670+100  "${request_id}/tweets_count".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image for title "Folllowing"
convert -background none -size 300x80 -font Verdana -fill white -pointsize 22 -gravity West label:"Following" "${request_id}/following_header".gif
# Place the title on the image
composite -geometry  +820+40  "${request_id}/following_header".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image for following count
convert -background none -size "${following_bwidth}"x"${following_bheight}" -font Verdana -fill white -pointsize 28 -gravity West label:"${following}" "${request_id}/following".gif
# Place the title for following count
composite -geometry  +820+80  "${request_id}/following".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image for title "Followers"
convert -background none -size 300x80 -font Verdana -fill white -pointsize 22 -gravity West label:"Followers" "${request_id}/followers_header".gif
# Place the follower title on the image
composite -geometry  +670+140  "${request_id}/followers_header".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image for follower count
convert -background none -size "${followers_bwidth}"x"${followers_bheight}" -font Verdana -fill white -pointsize 28 -gravity West label:"${followers}" "${request_id}/followers".gif
# Place the follower count on the image
composite -geometry  +670+180  "${request_id}/followers".gif "${request_id}/profile".gif "${request_id}/profile".gif

# Generate the image for the title "Likes"
convert -background none -size 300x80 -font Verdana -fill white -pointsize 22 -gravity West label:"Likes" "${request_id}/likes_header".gif
# Place the likes title on the image
composite -geometry  +820+140 "${request_id}/likes_header".gif "${request_id}/profile".gif "${request_id}/profile".gif 

# Generate the image for the likes count
convert -background none -size "${likes_bwidth}"x"${likes_bheight}" -font Verdana -fill white -pointsize 28 -gravity West label:"${likes}" "${request_id}/likes".gif
# Place the likes count on the image
composite -geometry  +820+180  "${request_id}/likes".gif "${request_id}/profile".gif "${request_id}/profile".gif
