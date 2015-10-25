(reds * 2 [3 4 5])

(cons 2 (reds * 6 (4 5)))

(cons 2 (cons 6 (reds * 24 (5))))

(cons 2 (cons 6 (cons 24 (reds * 120 ()))))

(cons 2 (cons 6 (cons 24 '(120))))

24 120)
6 24 120)
2 6 24 120)
=> (2 6 24 120)

form that triggers base case: (reds * 120 '())
