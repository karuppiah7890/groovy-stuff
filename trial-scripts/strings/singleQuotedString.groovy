def plainJavaString = 'a single-quoted string'
def noSupportForInterpolation = 'this is a string - $plainJavaString'

assert plainJavaString == 'a single-quoted string'
assert noSupportForInterpolation == 'this is a string - $plainJavaString'
