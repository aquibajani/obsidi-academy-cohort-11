/*
 Pseudocode:
 // Define an asynchronous function using the async keyword
    // Simulate an asynchronous operation with a Promise that resolves after 4 second
    // Return an object with a message property having value "Data fetched successfully"

 // Call the asynchronous function using await
    // Under try block
        // Print "Fetching data..."
        // Call getData and wait for the data to be fetched using await
        // Log the message property of the returned object to the console
    //Under catch block
        // Log any errors to the console concatinating "Error fetching data:" with the error

 // Call the startTask function to start the program
*/

async function getData() {
  let myPromise = new Promise((resolve, reject) => {
    resolve({ message: "Data fetched successful!" });
    reject("Something went wrong!");
  });
  setTimeout(() => {
    myPromise
      .then((message) => {
        console.log(message);
      })
      .catch((error) => {
        console.log(
          error,
        ); /* what code to run once the promise has declared its failure to complete the promise code */
      });
  }, 4000);
}

async function startTask() {
  try {
    console.log("Fetching data...");
    let response = await getData();
    if (response) {
      console.log(response.message);
    }
  } catch (error) {
    console.log(error);
  }
}

startTask();
