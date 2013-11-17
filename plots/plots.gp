set datafile separator ','
set xrange [0:25]
set term pngcairo dashed size 2048, 1536 

set style line 1 pt 7 lw 2 lc rgb "red" lt 1
set style line 2 pt 7 lw 2 lc rgb "green" lt 3
set style line 3 pt 7 lw 2 lc rgb "blue" lt 7

# 20

set output 'out/20/add.png'
plot 'data' every ::1::3 u 3:8 ls 1 t 'Java' w lines,\
     'data' every ::1::3 u 3:8:9 ls 1 t 'Java error' with errorbars,\
     'data' every ::7::9 u 3:8 ls 2 t 'Scala' w lines,\
     'data' every ::7::9 u 3:8:9 ls 2 t 'Scala error' with errorbars,\
     'data' every ::13::15 u 3:8 ls 3 t 'New Scala' w lines,\
     'data' every ::13::15 u 3:8:9 ls 3 t 'New Scala error' with errorbars

set output 'out/20/contains.png'
plot 'data' every ::19::21 u 3:8 ls 1 t 'Java' w lines,\
     'data' every ::19::21 u 3:8:9 ls 1 t 'Java error' with errorbars,\
     'data' every ::25::27 u 3:8 ls 2 t 'Scala' w lines,\
     'data' every ::25::27 u 3:8:9 ls 2 t 'Scala error' with errorbars,\
     'data' every ::31::33 u 3:8 ls 3 t 'New Scala' w lines,\
     'data' every ::31::33 u 3:8:9 ls 3 t 'New Scala error' with errorbars

set output 'out/20/remove.png'
plot 'data' every ::37::39 u 3:8 ls 1 t 'Java' w lines,\
     'data' every ::37::39 u 3:8:9 ls 1 t 'Java error' with errorbars,\
     'data' every ::43::45 u 3:8 ls 2 t 'Scala' w lines,\
     'data' every ::43::45 u 3:8:9 ls 2 t 'Scala error' with errorbars,\
     'data' every ::49::51 u 3:8 ls 3 t 'New Scala' w lines,\
     'data' every ::49::51 u 3:8:9 ls 3 t 'New Scala error' with errorbars

set output 'out/20/contains-not-exists.png'
plot 'data' every ::55::57 u 3:8 ls 1 t 'Java' w lines,\
     'data' every ::55::57 u 3:8:9 ls 1 t 'Java error' with errorbars,\
     'data' every ::61::63 u 3:8 ls 2 t 'Scala' w lines,\
     'data' every ::61::63 u 3:8:9 ls 2 t 'Scala error' with errorbars,\
     'data' every ::67::69 u 3:8 ls 3 t 'New Scala' w lines,\
     'data' every ::67::69 u 3:8:9 ls 3 t 'New Scala error' with errorbars

# 100

set output 'out/100/add.png'
plot 'data' every ::4::6 u 3:8 ls 1 t 'Java' w lines,\
     'data' every ::4::6 u 3:8:9 ls 1 t 'Java error' w errorbars,\
     'data' every ::10::12 u 3:8 ls 2 t 'Scala' w lines,\
     'data' every ::10::12 u 3:8:9 ls 2 t 'Scala error' w errorbars,\
     'data' every ::16::18 u 3:8 ls 3 t 'New Scala' w lines,\
     'data' every ::16::18 u 3:8:9 ls 3 t 'New Scala error' w errorbars

set output 'out/100/contains.png'
plot 'data' every ::22::24 u 3:8 ls 1 t 'Java' w lines,\
     'data' every ::22::24 u 3:8:9 ls 1 t 'Java error' with errorbars,\
     'data' every ::28::30 u 3:8 ls 2 t 'Scala' w lines,\
     'data' every ::28::30 u 3:8:9 ls 2 t 'Scala error' with errorbars,\
     'data' every ::34::36 u 3:8 ls 3 t 'New Scala' w lines,\
     'data' every ::34::36 u 3:8:9 ls 3 t 'New Scala error' with errorbars

set output 'out/100/remove.png'
plot 'data' every ::40::42 u 3:8 ls 1 t 'Java' w lines,\
     'data' every ::40::42 u 3:8:9 ls 1 t 'Java error' with errorbars,\
     'data' every ::46::48 u 3:8 ls 2 t 'Scala' w lines,\
     'data' every ::46::48 u 3:8:9 ls 2 t 'Scala error' with errorbars,\
     'data' every ::52::54 u 3:8 ls 3 t 'New Scala' w lines,\
     'data' every ::52::54 u 3:8:9 ls 3 t 'New Scala error' with errorbars

set output 'out/100/contains-not-exists.png'
plot 'data' every ::58::60 u 3:8 ls 1 t 'Java' w lines,\
     'data' every ::58::60 u 3:8:9 ls 1 t 'Java error' with errorbars,\
     'data' every ::64::66 u 3:8 ls 2 t 'Scala' w lines,\
     'data' every ::64::66 u 3:8:9 ls 2 t 'Scala error' with errorbars,\
     'data' every ::70::72 u 3:8 ls 3 t 'New Scala' w lines,\
     'data' every ::70::72 u 3:8:9 ls 3 t 'New Scala error' with errorbars
