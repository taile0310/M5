// Đệ quy fibonacci
var fibonacci = function (num) {
    if (num <= 1) {
        return num;
    }
    return fibonacci(num - 1) + fibonacci(num - 2);
};
// triển khai dãy fibonacci và tính tổng
var number = 10;
var sum = 0;
console.log("Dãy số fibonacci là : ");
for (var i = 0; i < number; i++) {
    console.log(fibonacci(i));
    sum += fibonacci(i);
}
// console.log("Tổng dãy fibonacci là: " + sum);
alert(sum);
