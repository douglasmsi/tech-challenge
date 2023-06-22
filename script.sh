#!/bin/bash

output_file="output.txt"

# Find all the .java files recursively in the current directory
files=$(find . -type f -name "*.java")

# Loop through each file and append its contents to the output file
for file in $files; do
  echo "File: $file" >> "$output_file"
  cat "$file" >> "$output_file"
  echo -e "\n---\n" >> "$output_file"
done
