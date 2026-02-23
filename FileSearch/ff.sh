#!/bin/bash

# Create main directory
mkdir -p documents

# Create files in documents
touch documents/file.csv

# Create rep and its files
mkdir -p documents/rep
touch documents/rep/example.txt
touch documents/rep/file2.csv
touch documents/rep/file2.xml

# Create directory33 inside rep
mkdir -p documents/rep/directory33
touch documents/rep/directory33/file.txt
touch documents/rep/directory33/test.png

# Create directory22 inside rep
mkdir -p documents/rep/directory22
touch documents/rep/directory22/test.gif

# Create directory435 and its file
mkdir -p documents/directory435
touch documents/directory435/test33.xls

echo "Structure created successfully!"