package com.javahash.spring.util;

import java.util.Collection;

public class IterableUtils {
	
	public static int size(Iterable<?> it) {
		  if (it instanceof Collection)
		    return ((Collection<?>)it).size();

		  // else iterate

		  int i = 0;
		  for (Object obj : it) i++;
		  return i;
	}

}
