export class Validation {

    checkEmail(email) {
        //Regex for email
        const EMAIL = /\S+@\S+\.\S+/;
        return EMAIL.test(email);
    }

    checkID(id) {
        //Regex for ID (9 numbers)
        const ID = /(\d){9}/;
        return ID.test(id);
    }

    checkDated(date) {
        //flag check if date is invalid
        let check = true;

        //Regex for date
        const DATE = /^(\d){2}[\/](\d){2}[\/](\d){4}/;
        check = check && DATE.test(date);

        //Get day, month, year
        let days = date.split("/");
        let dd = days[0];
        let mm = days[1];
        let yy = days[2];

        //Check leap year
        let isLeapYear = ((yy % 4 === 0) && (yy % 100 !== 0)) || (yy % 400 === 0);

        //Number of days of each month
        let listDay;
        if (isLeapYear)
            listDay = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
        else listDay = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];

        check = check && (mm >= 1 && mm <= 12);
        check = check && (dd >= 1 && dd <= listDay[mm - 1]);

        return check;
    }

    checkPositiveNumber(number) {
        return number > 0;
    }

    checkStringEmpty(str) {
        return str.length === 0;
    }

    normalizationString(str) {
        //Delete redundant space
        str = str.replaceAll(/\s+/g," ").trim();

        //capitalize first letter
        let words = str.split(/\s/);
        let final = "";
        for (let word of words) {
            word = word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
            final += word + " ";
        }

        return final;
    }
}