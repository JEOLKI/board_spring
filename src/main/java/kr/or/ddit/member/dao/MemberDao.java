package kr.or.ddit.member.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import kr.or.ddit.member.model.MemberVo;

@Repository("memberRepository")
public class MemberDao implements MemberDaoI {
	
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSession;

	@Override
	public MemberVo getMember(String userId) {
		return sqlSession.selectOne("member.getMember", userId);
	}

}
