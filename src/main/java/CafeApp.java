


void main() {
    Input.open();
    Cafe cafe = new Cafe("Lexicon Cafe");
    while(cafe.open)
    {
        cafe.process();
    }
    cafe.printEndOfDayReport();
    Input.close();
}


