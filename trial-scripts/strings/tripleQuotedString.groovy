def plainJavaString = '''a triple-single-quoted string'''
def noSupportForInterpolation = '''this is a string - $plainJavaString'''
def aMultilineString = '''line one
line two
line three'''


assert plainJavaString == 'a triple-single-quoted string'
assert noSupportForInterpolation == 'this is a string - $plainJavaString'
assert aMultilineString == 'line one\nline two\nline three'
