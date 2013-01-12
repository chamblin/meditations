"""
The non-destructive linear insertion sort
"""

def sort(l):
	ret = []
	for i in range(len(l)):
		if(not ret or (ret[len(ret) - 1] <= l[i])):
			ret.append(l[i])
		else:
			inserted = False
			for j in range(len(ret)):
				if (ret[j] >= l[i] and not inserted):
					ret.insert(j, l[i])
					inserted = True
	return ret
	
print sort([1,2,3,4,1,2,3,4])
print sort([4,3,2,1])
print sort([1,2,3,4])
print sort([])
print sort([0,1,0,1,0,1])