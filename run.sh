#!/bin/bash

if [ "$#" -eq 0 ]; then
    echo "Usage: $0 path1.java path2.java ..."
    exit 1
fi

for full_path in "$@"
do
    clean_path="${full_path%,}"

    folder=$(dirname "$clean_path")

    mkdir -p "$folder"
    touch "$clean_path"
done
    cd "$folder"

echo "All files created successfully."