
offsets must not go backwards
startOffset=22009,endOffset=22010,lastStartOffset=22010


problem: the 2nd token has
been outputted and then the
second annotation is added

the second annotation should
have a smaller startPos

token start 22004
token end   22007

ann start:  22004
ann end:    22008
startpos:   0
endpos:     2

token start 22010
token end   22018


ann start:  22009
ann end:    22010
startpos:   1
endpos:     2


ann start:  22010
ann end:    22018
startpos:   1
endpos:     2




=====

startOffset=68543,endOffset=68548,lastStartOffset=68548

matching the first ann

token 68488, 68489
token 68490, 68497
token 68498, 68498
token 68534, 68539

ann 68541, 68542    Dimension
increment 1
startpos 0

ann 68548, 68553    Dimension
increment 0
startpos 0

the second annotation
is outputted at the same pos
as the first. not good,
as the first token should be outputted first

the match is indeed 1, as the first token below
generates both annotations

that is not correct

token 68543, 68548
token 68550, 68552
token 68555, 68560



===
from <= to <

startOffset=59522,endOffset=59525,lastStartOffset=59523 


tok 59508, 59509
tok 59510, 59513
tok 59514, 59515
tok 59516, 59518
tok 59519, 59520
tok 59522, 59525

ann 59520, 59521
ann 59523, 59524


pretoken match
with the changed rule

the second ann is not pretoken
but also captured by the token

is it enough to increment the
startpos in case of the pretokenmatch?

we also have to increase the endpos

but can't it get across the border of the match?
and what about consecutive matches and prematches




=== 

pos length

ann 9355
