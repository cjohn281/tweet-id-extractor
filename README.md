# Tweet ID Extractor
Extract Tweet IDs from a Panacea Lab's Covid-19 Tweet dataset.

## About
This application was built to easily extract Tweet IDs from Panacea Lab's large-scale COVID-19 Twitter chatter dataset and store them in a text file.
The resulting text file can then be used with a program, such as twarc to hydrate tweets into a usable json format.
It is intended to be used with the full_dataset_clean.tsv file, which can be downloaded from https://doi.org/10.5281/zenodo.3723939

## Requirements
In order to run this application, you must have JDK 11, Scala 2.12, or higher, and sbt installed.

## Usage
* Download full_dataset_clean.tsv from Zenodo at https://doi.org/10.5281/zenodo.3723939 and save it to the root of the project directory.
* Follow the comments within the Main class in src/main/scala/ The logic that needs to be altered for your purposes will be in the application's for loop:
>This is where you will likely want to make changes. The dataset that I used contained approx. 236 million tweets.

>I wanted approx. 2.5 million tweets per file.

>236,000,000 / 2,500,000 = 94.4

>Therefore, grab tweets in which count % 94 == 0.

>the count != 0 condition exists to skip the TSV file's header line.

>For additional files that contain the same number of tweets, simply change the 0 in count % 94 == 0 to a different

>value (be sure to change the name of your output file too).

* Set your input and output file names.
* sbt run.