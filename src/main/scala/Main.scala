import java.io.PrintWriter
import java.io.File


/** This program extracts the Tweet IDs from the Zenodo dataset (see ReadMe.md),
 * and stores them in a text file.  The intention is to use that text file with
 * twarc to hydrate tweets related to Covid-19.
 * 
 * @author Chris Johnson
 **/
object Main extends App {
  val inFile = io.Source.fromFile("full_dataset_clean.tsv")     // The input dataset
  val pw = new PrintWriter(new File("output.txt"))              // PrintWriter writes new output text file
  var count = 0                                                 // Counts the number of tweets in in the input file
  var entries = 0                                               // Counts the number of tweet ids written to the output file

  for (line <- inFile.getLines) {   // For each line in the input file...

    /*
    * This is where you will likely want to make changes. The dataset that I used contained approx. 236 million tweets.
    * I wanted approx. 2.5 million tweets per file.
    * 236,000,000 / 2,500,000 = 94.4
    * Therefore, grab tweets in which count % 94 == 0.
    * the count != 0 condition exists to skip the TSV file's header line.
    * For additional files that contain the same number of tweets, simply change the 0 in count % 94 == 0 to a different
    * value (be sure to change the name of your output file too).
    */
    if (count != 0 && count % 94 == 0) {
      var id = line.split("\t")(0)        // Split the line into an array of fields and grab the data at index 0 (the tweet id).
      pw.write(id + "\n")                 // Write the tweet id to the output file, followed by a newline character.
      entries += 1                        // Increment the variable that stores the number of tweet ids written to the output file.
    }     
    count += 1                            // Increment the variable that stores the number of tweets in the input file.
  }

  inFile.close()                          // Close the input file after reading in all tweets.
  pw.close                                // Close the output file after writing all tweet ids.
  
  println(s"Count: $count")               // Print the number of tweets in the input file to console.
  println(s"Entries: $entries")           // Print the number of tweet ids written to the output file to console.
}