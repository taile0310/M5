// Đệ quy fibonacci
let fibonacci = (num: number): number => {
    if (num <= 1) {
        return num;
    }
    return fibonacci(num - 1) + fibonacci(num - 2);
}

// triển khai dãy fibonacci và tính tổng

let number: number = 10;

let sum: number = 0;

console.log("Dãy số fibonacci là : ")

for (let i = 0; i < number; i++) {
    console.log(fibonacci(i));
    sum += fibonacci(i);
}

// console.log("Tổng dãy fibonacci là: " + sum);


alert(sum)