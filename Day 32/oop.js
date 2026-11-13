// Declare a constant variable using the "const" keyword
const PI = 3.14159;

// Define a class using the "class" keyword
class Shape {
  constructor(x, y) {
    this.x = x;
    this.y = y;
  }

  move(x, y) {
    this.x += x;
    this.y += y;
  }
}

// Define a subclass that extends the "Shape" class
class Circle extends Shape {
  constructor(x, y, radius) {
    super(x, y);
    this.radius = radius;
  }

  get area() {
    return PI * this.radius * this.radius;
  }

  set diameter(diameter) {
    this.radius = diameter / 2;
  }
}

// Create an instance of the "Circle" class

let myCircle = new Circle(0, 0, 10);

// Call the "move" method on the "circle" instance
myCircle.move(10, 10);

// Print the area of the circle using the "area" getter
console.log(myCircle.area);

// Set the diameter of the circle using the "diameter" setter
myCircle.diameter = 50;

// Print the area of the circle again
console.log(myCircle.area);
