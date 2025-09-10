export default function Recent({ product }) {
  useEffect(() => {
    // localStorage에서 가져오기, 최신 순으로 정렬하기
  }, []);

  // localStorage가 비어있으면, 
  // <div className="container py-4">최근 본 상품이 없습니다.</div>
  // 출력하기

  return (
    <div className="container py-4">
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h4 className="mb-0">최근 본 상품</h4>
        <button
          className="btn btn-outline-secondary btn-sm"
          onClick={() => {
            // localStorage 전체 지우는 코드 삽입
          }}
        >
          전체 지우기
        </button>
      </div>

      <div className="row g-3">
          <div className="col-6 col-md-4 col-lg-3" key={item.id}>
            <div
              className="card h-100"
              role="button"
              onClick={() => navigate(//상세페이지 보기로 이동)}
            >
              <img
                src={해당이미지보기}
                className="card-img-top"
                alt={title로 alt표시하기}
              />
              <div className="card-body">
                <div className="fw-semibold">신발제목</div>
                <div className="text-muted small">신발내용</div>
              </div>
            </div>
          </div>
        ))
      </div>
    </div>
  );
}
