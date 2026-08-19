
https://objectstore.surf.nl/87435b768620494e8e911c83d1997f24:globalise-data/objects/inventory/3598.index.json#/documents/3/fields



startOffset must be non-negative, and endOffset must be >= startOffset, and offsets must not go backwards startOffset=188349,endOffset=188352,lastStartOffset=188359 for field 'content'

token   188342  188344  "25"
ann     188342  118356
token   188349  188352  "140"
token   188365  118368  "115"
ann     188359  188361  isPretoken
ann     118365  118370
token   188373  118375  "de"





===


https://objectstore.surf.nl/87435b768620494e8e911c83d1997f24:globalise-data/objects/inventory/3598.index.json#/documents/2/fields

offsets must not go backwards
startOffset=22009,endOffset=22010,lastStartOffset=22010

the 2nd annotation falls between tokens
it cannot be outputted after the 2nd token

fix: decrement the startPos with 1 if the endpos is before the startpos
AND it's not the first match (that's the prematch logic)

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


===

from <= to <

startOffset=59522,endOffset=59525,lastStartOffset=59523 

problem:

the 1st ann starts between tokens.
it's tagged as a pretokenmatch: at the output, the first token is not outputted
the next annotation, a normal match, has a startpos of 0 as well.

that is correct, as there is one token eaten

tok 59508, 59509
tok 59510, 59513
tok 59514, 59515
tok 59516, 59518
tok 59519, 59520

tok 59522, 59525    b:s
ann 59520, 59521
ann 59523, 59524



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



