// 12. Inventory List

/*
add Shirt
remove Trouser
getList
*/

/* output
Shirt
*/

function inventoryList() {
    // write your code here
    
    let obj = {
        nameList : [],
        add(name) {
            for (let i = 0; i < this.nameList.length; i++) {
                if (this.nameList[i] === name) {
                    break;
                }  
            }
            this.nameList.push(name);
        },
        remove(name) {
            for (let i = 0; i < this.nameList.length; i++) {
                if (this.nameList[i] === name) {
                    this.nameList.splice(i, 1);
                    break;
                }
            }
        },
        getList() {
            return this.nameList;
        }
    }
    return obj;
  }
  
  
const obj = inventoryList();

const operationInfo =["add", "Shirt", "add", "Trouser", "getList", "remove", "Shirt", "getList"]; 
    let i = 0;
    while (i < operationInfo.length) {
        if (operationInfo[i] === 'add') {
            obj.add(operationInfo[i + 1]);
            console.log(i + ":" + obj.nameList);
            i = i + 2;
        } else if (operationInfo[i] === 'remove') {
            obj.remove(operationInfo[i + 1]);
            console.log(i + ":" + obj.nameList)
            i = i + 2;
        } else if (operationInfo[i] === 'getList') {
            const res = obj.getList();
            console.log(i + ":" + res);
            i++;
        }
    }

/* output
Shirt, Trouser
Trouser
*/