function convert() {
    let amount = Number(document.getElementById('amount').value);

    let from = document.getElementById('from').value;
    let to = document.getElementById('to').value;

    let baseCurrency;
    switch(from){
        case "VND":
            baseCurrency = 20000;
            break;
        case "USD":
            baseCurrency = 0.86;
            break;
    }

    let destCurrency;
    switch(to){
        case "VND":
            destCurrency = 20000;
            break;
        case "USD":
            destCurrency = 0.86;
            break;
    }

    let result = amount / baseCurrency * destCurrency;
    document.getElementById('result').innerHTML = result.toFixed(2) + " " + to;
}