# 베이스 이미지는 가볍고 Python 3.8이 설치된 slim 버전 사용
FROM python:3.8-slim

# 환경변수 설정 (파이썬이 버퍼링 안하게)
ENV PYTHONUNBUFFERED=1

# 작업 디렉토리 생성
WORKDIR /app

# 필요한 시스템 패키지 설치
RUN apt-get update && apt-get install -y \
    build-essential \
    curl \
    gcc \
    libffi-dev \
    libssl-dev \
    && rm -rf /var/lib/apt/lists/*

# requirements.txt 복사
COPY requirements.txt .

# 패키지 설치 (캐시 없이)
RUN pip install --no-cache-dir -r requirements.txt

# 애플리케이션 코드 복사
COPY . .

CMD ["uvicorn", "api.main_api:app", "--host", "0.0.0.0", "--port", "8000"]
