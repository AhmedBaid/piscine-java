#!/bin/bash

# Check if argument exists
if [ -z "$1" ]; then
    echo "Usage: $0 folder/file.java"
    exit 1
fi

# Full path
full_path="$1"

# Extract folder (before last /)
folder=$(dirname "$full_path")

# Create folder
mkdir -p "$folder"

# Create file
touch "$full_path"

cd $folder