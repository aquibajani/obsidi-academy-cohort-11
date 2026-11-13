"use strict";
// Define the tax rate as a constant variable
const TAX_RATE = 0.1;
// Define the invoice class using the "class" keyword
class Invoice {
    // Declare a constructor
    items;
    constructor() {
        this.items = [];
    }
    // Declare a method named addItem
    addItem(name, price, quantity) {
        this.items.push({ name, price, quantity });
    }
    // Declare a method named getSubTotal
    getSubtotal() {
        return this.items.reduce((acc, item) => acc + item.price * item.quantity, 0);
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
        this.items.forEach((item) => console.log(`${item.name}: $${item.price.toFixed(2)} x ${item.quantity}`));
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
