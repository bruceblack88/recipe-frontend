function getNthElement(array, n) {
    if (array.length <= 0) {
        return undefined;
    } else {
        for (let i = 0; i < array.length; i++) {
            if(i===n){
                return array[i];
            }
        }
    }
}
var output = getNthElement([1, 3, 5], 1);
console.log(output); // --> 3