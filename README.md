# Minesweeper

Hey, it's minesweeper! Sort of.

## How to mine

First line of user input is the minefield. Commas (,) indicate row breaks.
The letter 'x' means an empty cell. The letter 'm' means a mine.
 
    Enter the minefield layout:
    xxmm,xmxx,xxxx,mxxm


## How to sweep

After that you specify whether to flag or open a cell. You open a cell by 
typing "o" and the cell coordinates.

    Enter option: 
    o(2,1)
    
    xxxx
    xx0x
    xxxx
    xxxx
    
The Xs on that map are spaces you haven't touched yet. The "0" means you
opened that cell and it was clear.

You flag a cell by typing "f" and the cell coordinates. Flags are marked on
the map by the letter "f."

    Enter option: 
    f(0,3)
    
    xxxx
    xx0x
    xxxx
    fxxx
        
Open all the empty cells and flag all the mines, and you win. Be careful!