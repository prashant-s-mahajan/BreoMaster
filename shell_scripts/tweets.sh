#!/bin/bash
# Assign the command line parameters
request_id=$1 # Request Id
tweet=$2 # Tweet
background_image=$3 # Background Image
count=$4 # Tweet count

echo $request_id
echo $tweet
echo $background_image
echo $count

# Check if it's the first tweet
if [ "$count" -eq 1 ]
then
	if [ "$background_image" == "null" ]; 
	then
		# Resize the background image
		 convert -size 1000x400 xc:black "${request_id}/background_dark".jpeg
	else
		# Resize the background image
		convert ${background_image} -resize 1000x400 "${request_id}/background_dark".jpeg

		# Increase the darkness of the background image
		# convert "${request_id}/background_dark".jpeg +level 20% "${request_id}/background_dark".jpeg
	fi
 
	# Resize the background image
	# convert ${background_image} -resize 1000x400 "${request_id}/background_dark".jpeg

	# Increase the darkness of the background image
	# convert "${request_id}/background_dark".jpeg +level 20% "${request_id}/background_dark".jpeg
fi

# Generate the image
convert -background '#0004' -fill white -font TahomaB -gravity center -size 1000x100 caption:"${tweet}" "${request_id}/background_dark".jpeg +swap -gravity center -composite  "${request_id}/screen_${count}".jpeg
