#!/bin/bash

# Read the command line arguments
request_id=$1
text=$2
background_image_url=$3
index=$4
brightness=$5
background_color=$6
font_color=$7
width=$8
height=$9
position=${10}

# create a directory
mkdir -p "temp/${request_id}"

# download the image
wget $background_image_url -O "temp/${request_id}/${index}.jpeg"

# darken or brighten the image
convert "temp/${request_id}/${index}.jpeg" -brightness-contrast $brightness "temp/${request_id}/${index}.jpeg"

# make it grey
convert "temp/${request_id}/${index}.jpeg" +level 10% "temp/${request_id}/${index}.jpeg"

# add the text
convert -background $background_color -fill $font_color -font TahomaB -gravity center -size "${width}x${height}" caption:"${text}" "temp/${request_id}/${index}.jpeg" +swap -gravity $position -composite "temp/${request_id}/${index}.jpeg"

echo -e "\nRequest Id      	   : ${request_id}"
echo -e  "\nText	 	   : ${text}"
echo -e "\nIndex	 	   : ${index}"
echo -e "\nBackground Image URL    : ${background_image_url}"
echo -e "\nBrightness	   	   : ${brightness}"
echo -e "\nBackground Color        : ${background_color}"
echo -e "\nFont Color		   : ${font_color}"
echo -e "\nWidth		   : ${width}"
echo -e "\nHeight 		   : ${height}"
echo -e "\nPosition		   : ${position}"
