function jsArrayPractice(array, n) {
    if (array.length <= 0) {
        return undefined;
    } else {
        for (let i = 0; i < array.length; i++) {
            if (i === n) {
                return array[i];
            }
        }
    }
}

var output = jsArrayPractice([1, 3, 5], 1);
console.log(output); // --> 3
console.log("**************")

function getFirstElement(array) {
    if (array.length <= 0) {
        return undefined;
    } else {
        return array[0];
    }
}

var output = getFirstElement([1, 2, 3, 4, 5]);
console.log(output); // --> 1
console.log("**************")

function getLastElement(array) {
    if (array.length <= 0) {
        return undefined;
    } else {
        let lastElement = array[array.length -1];
        return lastElement;
    }
}

var output = getLastElement([1, 2, 3, 4]);
console.log(output); // --> 4
console.log("**************")

function addToFront(arr, element) {
arr.unshift(element);
return arr;
}
var output = addToFront([1, 2], 3);
console.log(output); // -> [3, 1, 2]
console.log("**************")

function addToBack(arr, element) {
arr.push(element);
return arr;

}
var output = addToBack([1, 2], 3);
console.log(output); // -> [1, 2, 3]
console.log("**************")
function joinArrays(arr1, arr2) {
    for (let i = 0; i < arr2.length; i++) {
        arr1.push(arr2[i]);
    }
return arr1;
}
var output = joinArrays([1, 2], [3, 4]);
console.log(output); // --> [1, 2, 3, 4]
console.log("**************")
function getElementsAfter(array, n) {
return array.slice(n +1, array.length);
}
var output = getElementsAfter(['a', 'b', 'c', 'd', 'e'], 2);
console.log(output); // --> ['d', 'e']
console.log("**************")

function getElementsUpTo(array, n) {
array.splice(n)
return array;
}
var output = getElementsUpTo(['a', 'b', 'c', 'd', 'e'], 3)
console.log(output); // --> ['a', 'b', 'c']
console.log("**************")
function getAllElementsButFirst(array) {

    return array.slice(1)
}
var input = [1, 2, 3, 4];
var output = getAllElementsButFirst(input);
console.log(output); // --> [2, 3, 4]


function getAllElementsButLast(array) {
    array.pop(array.length);
    return array;
}
var input = [1, 2, 3, 4];
var output = getAllElementsButLast(input);
console.log(output); // --> [1, 2 , 3]
console.log("**************")

function removeFromFront(arr) {
return arr.slice(1);
}
var output = removeFromFront([1, 2, 3]);
console.log(output); // --> [2, 3]
console.log("**************")

function removeFromBackOfNew(arr) {
const newArr = arr.slice();
newArr.pop()
return newArr;
return arr;
}
var arr = [1, 2, 3];
var output = removeFromBackOfNew(arr);
console.log(output); // --> [1, 2]
console.log(arr); // --> [1, 2, 3]
console.log("**************")

function removeFromFrontOfNew(arr) {
const newArr = arr.slice(1);
return newArr;
return arr;
}
var arr = [1, 2, 3];
var output = removeFromFrontOfNew(arr);
console.log(output); // --> [2, 3]
console.log(arr); // --> [1, 2, 3]
console.log("**************")

function countCharacter(str, char) {
    let count = 0;
    for (let i = 0; i < str.length; i++) {
        if(str[i] === char){
            count++;
        }
    }
    return count;
}
var output = countCharacter('I am a hacker', 'a');
console.log(output); // --> 3
console.log("**************")

function removeFromBack(arr) {
    arr.pop();
    return arr;
}
var output = removeFromBack([1, 2, 3]);
console.log(output); // --> [1, 2]
console.log("**************")



function joinThreeArrays(arr1, arr2, arr3) {
    const arr = [];
    for (let i = 0; i < arr1.length; i++) {
        arr.push(arr1[i]);
    }
    for (let i = 0; i < arr2.length; i++) {
        arr.push(arr2[i]);
    }
    for (let i = 0; i < arr3.length; i++) {
        arr.push(arr3[i]);
    }
    return arr;
}
var output = joinThreeArrays([1, 2], [3, 4], [5, 6]);
console.log(output); // --> [1, 2, 3, 4, 5, 6]
console.log("**************")