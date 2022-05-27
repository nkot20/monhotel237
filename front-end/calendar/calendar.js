var date = new Date()
date.setMinutes(date.getMinutes() - date.getTimezoneOffset())
var datestr = date.toISOString().substring(0, 10)
var field = document.getElementById("dateca")
field.value = datestr
console.log(date)

function onNext() {
    let monthPrevious = date.getMonth()
    let year = date.getFullYear()
    let nbDayMonthNext = getNbDayOfMonthInYear(monthPrevious + 2, year)
    let nbDayMonthPrevious = getNbDayOfMonthInYear(monthPrevious + 1, year)
    console.log(nbDayMonthPrevious)
    let datesMonthNext = new Array()
    let datesMonthPrevious = new Array()

    for (let index = 1; index <= nbDayMonthNext; index++) {
        let newDate = new Date()

        newDate.setDate(index)
        newDate.setMonth(monthPrevious + 1)
        newDate.setFullYear(year)
        datesMonthNext.push(newDate)

    }
    for (let index = 1; index <= nbDayMonthPrevious; index++) {
        let newDate = new Date()
        newDate.setDate(index)
        newDate.setMonth(monthPrevious)
        newDate.setFullYear(year)
        datesMonthPrevious.push(newDate)

    }
    // console.log(datesMonthNext)
    // console.log(datesMonthPrevious)
    console.log(datesMonthPrevious[datesMonthPrevious.length - 1])
    date.setMonth(date.getMonth() + 1)
    field.value = date.toISOString().substring(0, 10)

    let k = datesMonthPrevious[datesMonthPrevious.length - 1].getDay()
    let i = 1
    let tr = "<tbody><tr>"
    console.log()
    while (i <= k) {
        tr += "<td></td>"
        i++
    }

    let j = 0
    while (j < nbDayMonthNext) {

        if (datesMonthNext[j].getDay() == i) {
            tr += "<td>" + datesMonthNext[j].getDay() + "/" + datesMonthNext[j].getMonth() + "</td>"
            i = datesMonthNext[j].getDay() + 1

        }
        console.log(j, i)
        if ((j + i) % 7 == 0) {
            tr += "</tr><tr>"
            i = 0
        }

        j++
    }

    tr += "</tbody>"

    document.getElementById("content").innerHTML = tr

}

function onPrevious() {
    let monthPrevent = date.getMonth()
    date.setMonth(date.getMonth() - 1)
    field.value = date.toISOString().substring(0, 10)

}

function getNbDayOfMonthInYear(month, year) {
    return new Date(year, month, 0).getDate()
}

function writeCalendar() {

}