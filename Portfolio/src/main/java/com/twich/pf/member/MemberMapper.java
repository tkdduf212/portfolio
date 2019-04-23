package com.twich.pf.member;

public interface MemberMapper {
	public abstract int memberJoin(Member m);
	public abstract Member getMemberID(Member m);
	public abstract int memberUpdate(Member m);
	public abstract int memberBye(Member m);
}
