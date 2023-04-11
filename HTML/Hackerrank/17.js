// 17. Table of Contents

/*
10
# Cars
Cars came into global use during the 20th century
Most definitions of car say they run primarily on roads
## Sedan
Sedan's first recorded use as a name for a car body was in 1912
## Coupe
A coupe is a passenger car with a sloping rear roofline and generally two doors
## SUV
The predecessors to SUVs date back to military and low-volume models from the late 1930s
There is no commonly agreed definition of an SUV, and usage varies between countries.
*/

/* output
1. Cars
1.1. Sedan
1.2. Coupe
1.3. SUV
*/


/*
 * Complete the 'tableOfContents' function below.
 *
 * The function is expected to return a STRING_ARRAY.
 * The function accepts STRING_ARRAY text as parameter.
 */

function tableOfContents(text) {
    // Write your code here
    let chapter = 1;
    let section = 1;
    let result = [];
    
    for (let i = 0; i < text.length; i++) {
        if (text[i].substring(0, 2) === "# ") {
            result.push(chapter + ". " + text[i].substring(2)); 
            chapter++;
            section = 1;
        } else if (text[i].substring(0, 2) === "##") {
            result.push((chapter - 1) + "." + section + ". " + text[i].substring(3));
            section++;
        }
    }
    return result;
}