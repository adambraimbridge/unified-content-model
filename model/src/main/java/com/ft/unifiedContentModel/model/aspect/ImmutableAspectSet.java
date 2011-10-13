package com.ft.unifiedContentModel.model.aspect;

import static org.springframework.util.Assert.notNull;

import java.util.Set;

import com.ft.unifiedContentModel.model.AspectSetAware;
import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

public final class ImmutableAspectSet implements AspectSet {

	private AssignableVoter assignableVoter;
	private NamedNode<Aspect> namedNode;

	private ImmutableAspectSet(String name, Set<Aspect> aspects, AssignableVoter assignableVoter) {
		notNull(assignableVoter);
		namedNode = new NamedNode<Aspect>(name, aspects);
		this.assignableVoter = assignableVoter;
	}

	public static ImmutableAspectSet valueOf(String name, Set<Aspect> aspects, AssignableVoter assignableVoter) {
		return new ImmutableAspectSet(name, aspects, assignableVoter);
	}

	@Override
	public void applyTo(AspectSetAware aspectSetAware) {
		aspectSetAware.setAspectSet(toString());
		aspectSetAware.setAspects(Lists.newArrayList(Iterables.transform(namedNode.getChildren(), 
				new Function<Aspect, String>() {
					@Override
					public String apply(Aspect input) {
						return input.toString();
					}
				})));
	}

	@Override
	public boolean assignableFrom(Object object) {
		return assignableVoter.vote(namedNode.getChildren(), object);
	}

	@Override
	public boolean equals(Object that) {
		if (!(that instanceof ImmutableAspectSet)) {
			return false;
		}
		ImmutableAspectSet thatAspectSet = (ImmutableAspectSet) that;
		return namedNode.equals(thatAspectSet.namedNode);
	}

	@Override
	public int hashCode() {
		return namedNode.hashCode();
	}
	
	@Override
	public String toString() {
		return namedNode.toString();
	}

	@Override
	public int compareTo(AspectSet that) {
		return toString().compareTo(that.toString());
	}
}
