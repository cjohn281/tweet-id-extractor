# tweet-id-extractor
Extract Tweet IDs from a Panacea Lab's Covid-19 Tweet dataset.

## About
This application was built to easily extract Tweet IDs from Panacea Lab's large-scale COVID-19 Twitter chatter dataset and store them in a text file.
The resulting text file can then be used with a program, such as twarc to hydrate tweets into a usable json format.
It is intended to be used with the full_dataset_clean.tsv file, which can be downloaded from https://zenodo.org/record/4484079#.YCALM2hKiUl

## Requirements
In order to run this application, must have JDK 11 and Scala 2.12, or higher, installed.

## Usage