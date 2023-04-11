// 2. Student Record Manipulation

/*
name John
lastName Bliss
city Florida
edit city Seattle
*/

/* output
city Seattle
lastName Bliss
name John
*/

/*
name John
lastName Bliss
city Florida
delete city
*/

/* output
city Florida
lastName Bliss
name John
*/

function manipulateStudentRecord(obj, operation, prop, newValue) {
    // write your code here
    if (operation === "delete") {
        let newObj = {};
        for (const o in obj) {
            if (o != prop) {
                newObj[o] = obj[o];
            }
        }
        newValue = undefined;
        return newObj;
    }
    if (operation === "edit") {
        for (const o in obj) {
            if (o === prop) {
                obj[o] = newValue;
            }
        }
        return obj;
    }
  }