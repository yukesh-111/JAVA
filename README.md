import React, { useState, useEffect, useRef } from 'react';

// Define types
type Option = {
  id: string;
  label: string;
};

type Selection = {
  number: number;
  selectedOption: string | null;
};

// Simple mock components (same as before)
const Button = ({ children, onClick, variant = 'default', className = '', disabled = false }: any) => (
  <button 
    onClick={onClick} 
    disabled={disabled}
    className={`px-4 py-2 rounded-md ${
      variant === 'default' ? 'bg-blue-600 text-white hover:bg-blue-700' : 
      variant === 'outline' ? 'border border-gray-300 hover:bg-gray-50' : 
      variant === 'destructive' ? 'bg-red-600 text-white hover:bg-red-700' : ''
    } ${className}`}
  >
    {children}
  </button>
);

const Card = ({ children, className = '' }: any) => (
  <div className={`bg-white rounded-lg shadow-md ${className}`}>
    {children}
  </div>
);

const CardHeader = ({ children, className = '' }: any) => (
  <div className={`p-6 border-b ${className}`}>
    {children}
  </div>
);

const CardTitle = ({ children, className = '' }: any) => (
  <h3 className={`text-xl font-semibold ${className}`}>
    {children}
  </h3>
);

const CardContent = ({ children, className = '' }: any) => (
  <div className={`p-6 ${className}`}>
    {children}
  </div>
);

const Label = ({ children, htmlFor, className = '' }: any) => (
  <label htmlFor={htmlFor} className={`text-sm font-medium ${className}`}>
    {children}
  </label>
);

// Start Screen Component (same as before)
const StartScreen = ({ onStart, isRetry = false }: { onStart: () => void; isRetry?: boolean }) => {
  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-50">
      <Card className="w-full max-w-md mx-4">
        <CardHeader>
          <CardTitle className="text-2xl text-center">MoCT Test</CardTitle>
        </CardHeader>
        <CardContent className="space-y-6">
          <div className="text-center">
            <p className="mb-6">
              {isRetry 
                ? 'Would you like to take the test again?' 
                : 'Welcome to the Computer-Based Test'}
            </p>
            <p className="text-sm text-gray-500 mb-8">
              You will have 2 hours to complete 100 questions. The test will automatically submit when time expires.
            </p>
            <Button
              className="px-8 py-4 text-lg font-medium"
              onClick={onStart}
            >
              {isRetry ? 'Start New Test' : 'Start Test'}
            </Button>
          </div>
        </CardContent>
      </Card>
    </div>
  );
};

// Results Page Component (updated for 100 questions)
const ResultsPage = ({ 
  selections, 
  score, 
  completionType, 
  onReturnHome 
}: { 
  selections: Selection[]; 
  score: number; 
  completionType: string; 
  onReturnHome: () => void 
}) => {
  const downloadResults = () => {
    const html = `
      <html>
        <head>
          <style>
            body { 
              font-family: Arial, sans-serif; 
              position: relative;
            }
            .watermark {
              position: absolute;
              opacity: 0.1;
              font-size: 120px;
              font-weight: bold;
              color: #000000;
              transform: rotate(-20deg);
              top: 40%;
              left: 10%;
              z-index: -1;
            }
            h1 { font-size: 24px; margin-bottom: 20px; }
            .info { margin-bottom: 20px; }
            table { width: 100%; border-collapse: collapse; margin-top: 20px; }
            th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }
            th { background-color: #f2f2f2; }
            .correct { background-color: #e6ffed; }
            .incorrect { background-color: #ffebee; }
          </style>
        </head>
        <body>
          <div class="watermark">Moct Test</div>
          <h1>MoCT Test Results</h1>
          <div class="info">
            <p>Completed on ${new Date().toLocaleString()}</p>
            <p>Status: ${completionType === 'auto' ? 'Auto-Submitted' : 'Manually Submitted'}</p>
            <p>Score: ${score}/100</p>
            <p>Percentage: ${score}%</p>
          </div>
          
          <table>
            <thead>
              <tr>
                <th>Question</th>
                <th>Answer</th>
                <th>Status</th>
              </tr>
            </thead>
            <tbody>
              ${selections.map(selection => {
                const isCorrect = selection.selectedOption === 'A';
                return `
                  <tr class="${isCorrect ? 'correct' : 'incorrect'}">
                    <td>${selection.number}</td>
                    <td>${selection.selectedOption || 'Not answered'}</td>
                    <td>${isCorrect ? '✓ Correct' : '✗ Incorrect'}</td>
                  </tr>
                `;
              }).join('')}
            </tbody>
          </table>
        </body>
      </html>
    `;

    const blob = new Blob([html], { type: 'text/html' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `moct-test-results-${new Date().toISOString().slice(0,10)}.html`;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);
  };

  return (
    <div className="min-h-screen bg-gray-50 py-8 px-4">
      <Card className="w-full max-w-4xl mx-auto">
        <CardHeader>
          <CardTitle className="text-2xl">Test Results</CardTitle>
          <div className="flex justify-between items-center">
            <p className="text-sm text-gray-500">
              Score: <span className="font-medium">{score}/100</span>
            </p>
            <p className="text-sm text-gray-500">
              Percentage: <span className="font-medium">{score}%</span>
            </p>
            <p className="text-sm text-gray-500">
              Status: <span className="font-medium">
                {completionType === 'auto' ? 'Auto-Submitted' : 'Manually Submitted'}
              </span>
            </p>
          </div>
        </CardHeader>
        <CardContent>
          <div className="space-y-6">
            <div className="grid grid-cols-1 md:grid-cols-3 gap-4">
              <div className="bg-green-100 p-4 rounded-lg">
                <div className="flex items-center gap-2">
                  <span className="font-medium">Correct Answers: {score}</span>
                </div>
              </div>
              <div className="bg-red-100 p-4 rounded-lg">
                <div className="flex items-center gap-2">
                  <span className="font-medium">Incorrect Answers: {100 - score}</span>
                </div>
              </div>
              <div className="bg-blue-100 p-4 rounded-lg">
                <div className="flex items-center gap-2">
                  <span className="font-medium">Percentage: {score}%</span>
                </div>
              </div>
            </div>

            <div className="border-t pt-6">
              <h3 className="font-semibold mb-4 text-center">Detailed Results (First 10 Questions)</h3>
              <div className="space-y-4">
                {selections.slice(0, 10).map(selection => {
                  const isCorrect = selection.selectedOption === 'A';
                  return (
                    <div key={`result-${selection.number}`} className="flex items-center justify-between p-3 rounded-lg bg-gray-50">
                      <div className="font-medium">Question {selection.number}</div>
                      <div className="flex items-center gap-4">
                        <span>Your answer: {selection.selectedOption || 'Not answered'}</span>
                        {isCorrect ? (
                          <span className="text-green-600">✓</span>
                        ) : (
                          <span className="text-red-600">✗</span>
                        )}
                      </div>
                    </div>
                  );
                })}
                <p className="text-center text-sm text-gray-500">
                  Showing first 10 questions. Download full results to see all answers.
                </p>
              </div>
            </div>
          </div>

          <div className="mt-8 flex justify-center gap-4">
            <Button
              variant="outline"
              className="px-8 py-4 text-lg font-medium"
              onClick={onReturnHome}
            >
              Return Home
            </Button>
            <Button
              className="px-8 py-4 text-lg font-medium"
              onClick={downloadResults}
            >
              Download Full Results
            </Button>
          </div>
        </CardContent>
      </Card>
    </div>
  );
};

// Main Test Component with 100 questions
function App() {
  const TOTAL_QUESTIONS = 100;
  const [view, setView] = useState<'start' | 'test' | 'results'>('start');
  const [selections, setSelections] = useState<Selection[]>(() => {
    const savedAnswers = localStorage.getItem('cbtAnswers100');
    return savedAnswers 
      ? JSON.parse(savedAnswers)
      : Array.from({ length: TOTAL_QUESTIONS }, (_, i) => ({
          number: i + 1,
          selectedOption: null,
        }));
  });
  
  const [timeLeft, setTimeLeft] = useState(2 * 60 * 60); // 2 hours in seconds
  const [testCount, setTestCount] = useState(0);
  const [submitted, setSubmitted] = useState(false);
  const [completionType, setCompletionType] = useState<'auto' | 'manual'>('manual');
  const [currentPage, setCurrentPage] = useState(0);
  const questionsPerPage = 10;
  const timerRef = useRef<NodeJS.Timeout>();

  const options: Option[] = [
    { id: 'A', label: 'A' },
    { id: 'B', label: 'B' },
    { id: 'C', label: 'C' },
    { id: 'D', label: 'D' },
  ];

  // Reset test when starting
  const resetTest = () => {
    setSelections(
      Array.from({ length: TOTAL_QUESTIONS }, (_, i) => ({
        number: i + 1,
        selectedOption: null,
      }))
    );
    setTimeLeft(2 * 60 * 60);
    setTestCount(prev => prev + 1);
    setSubmitted(false);
    setCurrentPage(0);
    setView('test');
  };

  // Start timer when test starts
  useEffect(() => {
    if (view === 'test') {
      timerRef.current = setInterval(() => {
        setTimeLeft(prev => {
          if (prev <= 1) {
            clearInterval(timerRef.current);
            handleAutoSubmit();
            return 0;
          }
          return prev - 1;
        });
      }, 1000);
    }

    return () => {
      if (timerRef.current) clearInterval(timerRef.current);
    };
  }, [view]);

  const handleOptionSelect = (number: number, optionId: string) => {
    setSelections(prevSelections =>
      prevSelections.map(selection =>
        selection.number === number
          ? { ...selection, selectedOption: optionId }
          : selection
      )
    );
  };

  const handleAutoSubmit = () => {
    localStorage.setItem('cbtAnswers100', JSON.stringify(selections));
    setCompletionType('auto');
    setSubmitted(true);
    setView('results');
  };

  const handleManualSubmit = () => {
    localStorage.setItem('cbtAnswers100', JSON.stringify(selections));
    setCompletionType('manual');
    setSubmitted(true);
    setView('results');
  };

  const saveAndStartNewTest = () => {
    const defaultName = `moct-test-${testCount > 0 ? `attempt-${testCount + 1}` : 'initial'}`;
    const filename = prompt('Save your current progress as:', defaultName) || defaultName;
    
    // Save current progress
    const html = `
      <html>
        <head>
          <style>
            body { 
              font-family: Arial, sans-serif; 
              position: relative;
            }
            .watermark {
              position: absolute;
              opacity: 0.1;
              font-size: 120px;
              font-weight: bold;
              color: #000000;
              transform: rotate(-20deg);
              top: 40%;
              left: 10%;
              z-index: -1;
            }
            h1 { font-size: 24px; margin-bottom: 20px; }
            .info { margin-bottom: 20px; }
            table { width: 100%; border-collapse: collapse; margin-top: 20px; }
            th, td { padding: 8px; text-align: left; border-bottom: 1px solid #ddd; }
            th { background-color: #f2f2f2; }
          </style>
        </head>
        <body>
          <div class="watermark">Moct Test</div>
          <h1>MoCT Test Progress - Attempt ${testCount + 1}</h1>
          <div class="info">
            <p>Saved on ${new Date().toLocaleString()}</p>
            <p>Time remaining: ${formatTime(timeLeft)}</p>
            <p>Questions answered: ${selections.filter(s => s.selectedOption !== null).length}/${TOTAL_QUESTIONS}</p>
          </div>
          
          <table>
            <thead>
              <tr>
                <th>Question</th>
                <th>Answer</th>
              </tr>
            </thead>
            <tbody>
              ${selections.map(selection => `
                <tr>
                  <td>${selection.number}</td>
                  <td>${selection.selectedOption || 'Not answered'}</td>
                </tr>
              `).join('')}
            </tbody>
          </table>
        </body>
      </html>
    `;

    const blob = new Blob([html], { type: 'text/html' });
    const url = URL.createObjectURL(blob);
    const a = document.createElement('a');
    a.href = url;
    a.download = `${filename}.html`;
    document.body.appendChild(a);
    a.click();
    document.body.removeChild(a);
    URL.revokeObjectURL(url);

    // Reset and start new test
    resetTest();
  };

  const formatTime = (seconds: number) => {
    const hrs = Math.floor(seconds / 3600);
    const mins = Math.floor((seconds % 3600) / 60);
    const secs = seconds % 60;
    return `${hrs.toString().padStart(2, '0')}:${mins.toString().padStart(2, '0')}:${secs.toString().padStart(2, '0')}`;
  };

  const completedCount = selections.filter(s => s.selectedOption !== null).length;
  const unansweredQuestions = selections.filter(s => s.selectedOption === null).map(s => s.number);
  const score = selections.filter(s => s.selectedOption === 'A').length;

  const totalPages = Math.ceil(TOTAL_QUESTIONS / questionsPerPage);
  const currentQuestions = selections.slice(
    currentPage * questionsPerPage,
    (currentPage + 1) * questionsPerPage
  );

  if (view === 'start') {
    return <StartScreen onStart={resetTest} isRetry={testCount > 0} />;
  }

  if (view === 'results') {
    return (
      <ResultsPage 
        selections={selections} 
        score={score} 
        completionType={completionType} 
        onReturnHome={() => setView('start')} 
      />
    );
  }

  return (
    <div className="min-h-screen bg-gray-50 py-8 px-4 relative">
      {/* Watermark */}
      <div className="fixed inset-0 flex items-center justify-center pointer-events-none z-0">
        <div className="text-gray-200 text-8xl font-bold opacity-20 -rotate-12">Moct Test</div>
      </div>
      
      {/* Timer */}
      <div className="fixed top-4 right-4 bg-white p-3 rounded-lg shadow-md z-50">
        <div className="text-lg font-bold">
          Time Remaining: {formatTime(timeLeft)}
        </div>
        <div className="text-sm text-gray-500">
          Attempt: {testCount + 1}
        </div>
      </div>
      
      <Card className="w-full max-w-4xl mx-auto relative z-10">
        <CardHeader>
          <CardTitle className="text-2xl">CBT Answer Sheet (100 Questions)</CardTitle>
          <div className="flex justify-between items-center">
            <p className="text-sm text-gray-500">
              Questions: {currentPage * questionsPerPage + 1}-{Math.min((currentPage + 1) * questionsPerPage, TOTAL_QUESTIONS)}
            </p>
            <div className="flex gap-4">
              <p className="text-sm text-gray-500">
                Answered: <span className="font-medium">{completedCount}/{TOTAL_QUESTIONS}</span>
              </p>
              <p className="text-sm text-gray-500">
                Unanswered: <span className="font-medium">{TOTAL_QUESTIONS - completedCount}</span>
              </p>
            </div>
          </div>
          {unansweredQuestions.length > 0 && (
            <p className="text-sm text-red-500">
              Unanswered questions: {unansweredQuestions.slice(0, 5).join(', ')}
              {unansweredQuestions.length > 5 ? `... (${unansweredQuestions.length} total)` : ''}
            </p>
          )}
        </CardHeader>
        <CardContent className="space-y-6">
          {/* Pagination Controls */}
          <div className="flex justify-between items-center">
            <Button
              variant="outline"
              onClick={() => setCurrentPage(prev => Math.max(prev - 1, 0))}
              disabled={currentPage === 0}
            >
              Previous Page
            </Button>
            <div className="text-sm text-gray-500">
              Page {currentPage + 1} of {totalPages}
            </div>
            <Button
              variant="outline"
              onClick={() => setCurrentPage(prev => Math.min(prev + 1, totalPages - 1))}
              disabled={currentPage === totalPages - 1}
            >
              Next Page
            </Button>
          </div>

          {/* Questions Grid */}
          <div className="grid grid-cols-5 gap-2 bg-blue-50 p-2 rounded-lg">
            <div className="font-bold text-center py-2 text-blue-800">Q.No</div>
            {options.map(option => (
              <div key={option.id} className="font-bold text-center py-2 text-blue-800">
                Option {option.label}
              </div>
            ))}
          </div>

          {currentQuestions.map(selection => (
            <div 
              key={`question-${selection.number}`} 
              className="grid grid-cols-5 gap-2 items-center p-2 hover:bg-gray-50 rounded-lg transition-colors"
            >
              <div className="font-medium text-center py-2 flex items-center justify-center text-gray-700">
                {selection.number}.
              </div>
              
              <div className="col-span-4 grid grid-cols-4 gap-2">
                {options.map(option => (
                  <div 
                    key={`${selection.number}-${option.id}`} 
                    className="flex justify-center items-center"
                  >
                    <input
                      type="radio"
                      id={`${selection.number}-${option.id}`}
                      name={`question-${selection.number}`}
                      value={option.id}
                      checked={selection.selectedOption === option.id}
                      onChange={() => handleOptionSelect(selection.number, option.id)}
                      className="h-6 w-6"
                      disabled={submitted}
                    />
                    <Label 
                      htmlFor={`${selection.number}-${option.id}`} 
                      className="ml-2 cursor-pointer"
                    >
                      {option.label}
                    </Label>
                  </div>
                ))}
              </div>
            </div>
          ))}

          {/* Quick Navigation */}
          <div className="mt-8 border-t pt-6">
            <h3 className="font-semibold mb-4 text-center">Quick Navigation</h3>
            <div className="flex flex-wrap gap-2 justify-center">
              {Array.from({ length: totalPages }, (_, i) => (
                <button
                  key={`page-${i}`}
                  onClick={() => setCurrentPage(i)}
                  className={`w-10 h-10 rounded-md flex items-center justify-center ${
                    currentPage === i
                      ? 'bg-blue-600 text-white'
                      : 'bg-gray-200 hover:bg-gray-300'
                  }`}
                >
                  {i + 1}
                </button>
              ))}
            </div>
          </div>

          <div className="mt-8 flex justify-center gap-4">
            <Button
              className="px-8 py-4 text-lg font-medium"
              disabled={completedCount < TOTAL_QUESTIONS || submitted}
              onClick={handleManualSubmit}
            >
              {submitted ? 'Submitted' : 'Submit Answers'}
            </Button>
            <Button
              variant="outline"
              className="px-8 py-4 text-lg font-medium"
              onClick={saveAndStartNewTest}
              disabled={submitted}
            >
              Save Progress & Start Next Test
            </Button>
          </div>
        </CardContent>
      </Card>
    </div>
  );
}

export default App;

