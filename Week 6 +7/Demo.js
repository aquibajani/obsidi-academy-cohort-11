// // var test = true;

// console.log(typeof test);
// // statically typed - static typing
// // dynamically typed - dynamic typing

// // var - global scope
// // let - block scope
// // const - constant value / block scope
// const myName = "test";

// console.log(testVar);
// let testLet = "Hello Let outside";
// var testVar = "Hello";
// console.log(testVar);
// console.log(testLet);

// {
//   testVar = "Brand New";

//   console.log(testVar);
//   let testLet = "Hello Let from block";
//   console.log(testLet);
// }

// console.log(testVar);

// console.log(testLet);

/*
// Declaring and assigning the accountTypes variable:
// let myArray = [1, "Hello", 56.99, "A"];
let accountTypes = ["savings", "checking", "credit card"];

// Just like with Java, the numbers in the examples below are called "indexes":
console.log(accountTypes[0]); // Returns "savings"
console.log(accountTypes[1]); // Returns "checking"
console.log(accountTypes[2]); // Returns "credit card"

// We can change or add new values to the array using bracket notation as well:
accountTypes[3] = "line of credit";

// Our new array, after line nine, would be ["savings", "checking", "credit card", "line of credit"]

// Because we defined our array with let, however, we could overwrite the whole thing by simply reassigning the variable. The following would empty the variable, leaving us with an instantiated array with nothing inside:
accountTypes = [];
*/
// Objects are defined using {curly braces}. You can instantiate an empty object, or fill it with key/value pairs that are separated with commas like so:
/*
let customerData = {
  firstName: "John",
  details:["1", "2"],
  secondName: "Doe",
  phoneNumber: "8675309",
  5: "5 is an ill-advised key, but it still works",
};

// From here, there are multiple ways to access our object. We can get the entire object, or specific keys/values like so:

// To print the entire object to the console, simply use its name:
console.log(customerData); // Prints { 5: "5 is an ill-advised key, but it still works", firstName: 'John', secondName: 'Doe', phoneNumber: '8675309' }

// To get a specific value when you know the key to which it belongs, use dot notation:
console.log(customerData.firstName); // Prints "John"

// In instances where dot notation won't work, like if someone defined their object to have keys that were simple numbers, you can use [bracket] notation to access the value:
// console.log(customerData.5) // Fails to run due to a syntax error.
console.log(customerData[5]); // Prints "5 is an ill-advised key, but it still works"
*/

let accountTypes = ["savings", "checking", "credit card"];

// Using the spread operator here will make Joe's accounts equal to the list from our original accountTypes variable: "savings", "checking", "credit card". The two arrays WILL NOT be linked, however:
let joesAccounts = [...accountTypes, "Hello"];

// Now, if we add something to our new variable...
joesAccounts.push("joesSecretStash");

// We will maintain the separation between joesAccounts and accountTypes, and only joesAccounts will be updated:
console.log(
  "This is Joe's accounts: ",
  joesAccounts,
  " and this is account types: ",
  accountTypes,
);
