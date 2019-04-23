package com.twich.pf.sns;

import java.util.List;

public interface SnsMapper {
	public abstract int getAllSnsMsgsCount();
	public abstract int writeSNSMsg(SnsMsg sm);
	public abstract List<SnsMsg> searchSnsMsg(SnsMsg sm);
	public abstract List<SnsMsg> getSnsMsgs(SnsMsgNo smn);
	public abstract SnsMsg getSnsMsg(SnsMsg sm);
	public abstract int updateSnsMsg(SnsMsg sm);
	public abstract int deleteSnsMsg(SnsMsg sm);
	public abstract List<SnsReply> getSnsReplys(SnsMsg sm);
	public abstract int writeSnsReply(SnsReply sr);
	public abstract int deleteSnsReply(SnsReply sr);
}
