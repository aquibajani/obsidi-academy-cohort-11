// Define the tax rate as a constant variable
const TAX_RATE = 0.1;

// let numbers = [1, 2, 3, 4, 4, 5];
// let total = numbers.reduce((sum, num) => (sum += num));
// console.log(total);
// let sum_numbers = 0;
// for (let i = 0; i < numbers.length; i++) {
//   sum_numbers += numbers[i];
// }
// console.log(sum_numbers);

// Define the invoice class using the "class" keyword
class Invoice {
  // Declare a constructor
  constructor() {
    this.items = [];
  }
  // Declare a method named addItem
  addItem(name, price, quantity) {
    this.items.push({ name, price, quantity });
  }

  // Declare a method named getSubTotal

  getSubtotal() {
    return this.items.reduce(
      (acc, item) => acc + item.price * item.quantity,
      0,
    );
  }

  // Declare a method named getTax
  getTax() {
    return this.getSubtotal() * TAX_RATE;
  }

  // Declare a method named getTotal
  getTotal() {
    return this.getSubtotal() + this.getTax();
  }

  // Declare a method named print
  print() {
    console.log("Items:");
    this.items.forEach((item) =>
      console.log(`${item.name}: $${item.price.toFixed(2)} x ${item.quantity}`),
    );
    console.log(`Subtotal: $${this.getSubtotal().toFixed(2)}`);
    console.log(`Tax: $${this.getTax().toFixed(2)}`);
    console.log(`Total: $${this.getTotal().toFixed(2)}`);
  }
}

// Create a new invoice instance
const invoice = new Invoice();
// Add items to the invoice
invoice.addItem("Item 1", 10.0, 2);
invoice.addItem("Item 2", 5.5, 3);
// Print the invoice details
invoice.print();
