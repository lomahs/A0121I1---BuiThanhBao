function createSelection(idSelect){
    let div = document.createElement("div");
    let select = document.createElement("select");
    select.id = idSelect;

    let option = [];
    for (let i = 1; i < arguments.length; i++){
        option[i] = document.createElement("option");
        option[i].value = arguments[i];

        select.appendChild(option[i]);
    }

    div.appendChild(select);

    return div;
}

function main() {
    let a = createSelection("da", "1", "2", "3");
    document.body.appendChild(a);
    console.log(a.value)
}