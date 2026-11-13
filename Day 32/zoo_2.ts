// Define an Animal class with a constructor that takes in a name and age for an animal, and a makeSound method that throws an error as it needs to be implemented in a subclass
class Animal {
  private name: string;
  private age: number;
  constructor(name: string, age: number) {
    this.name = name;
    this.age = age;
  }

  makeSound() {
    throw new Error("makeSound method must be implemented");
  }
}
// Define a Dog class that extends from the Animal class and takes in a name, age, and breed for a dog. It overrides the makeSound method to log "Woof! Woof!"
class Dog extends Animal {
  private breed: string;
  constructor(name: string, age: number, breed: string) {
    super(name, age);
    this.breed = breed;
  }

  makeSound() {
    console.log("Woof! Woof!");
  }
}
// Define a Cat class that extends from the Animal class and takes in a name, age, and color for a cat. It overrides the makeSound method to log "Meow! Meow!"
class Cat extends Animal {
  private color: string;
  constructor(name: string, age: number, color: string) {
    super(name, age);
    this.color = color;
  }

  makeSound() {
    console.log("Meow! Meow!");
  }
}
// Define a Zoo class with a constructor that initializes an empty array for animals. It has an addAnimal method that checks if the input parameter is an instance of Animal, and adds it to the animals array. It also has a makeAllSounds method that checks if the animals array is empty, and if not, loops through each animal in the array and logs its sound.
class Zoo {
  private animals: Animal[];
  constructor() {
    this.animals = [];
  }

  addAnimal(animal: Animal) {
    if (!(animal instanceof Animal)) {
      throw new Error("Invalid animal type");
    }
    this.animals.push(animal);
  }

  makeAllSounds() {
    if (this.animals.length === 0) {
      console.log("No animals in the zoo");
    } else {
      this.animals.forEach((animal) => animal.makeSound());
    }
  }
}

// Create a new instance of a dog and cat with their respective properties
const dog: Animal = new Dog("Max", 2, "Golden Retriever");
const cat: Animal = new Cat("Fluffy", 1, "White");
// Create a new instance of a zoo
const zoo: Zoo = new Zoo();
// Add the dog and cat instances to the zoo's animals array and also try adding an invalid animal
try {
  zoo.addAnimal(dog);
  zoo.addAnimal(cat);
  // zoo.addAnimal("Invalid animal"); // This will throw an error (Comment this line to pass the test case)
} catch (error) {
  console.error(error);
}
zoo.makeAllSounds();
